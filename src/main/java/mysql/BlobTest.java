package mysql;

import javax.swing.*;
import javax.swing.filechooser.FileFilter;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.FileInputStream;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Properties;

public class BlobTest {
    private static Connection conn;
    private static PreparedStatement insert;
    private static PreparedStatement query;
    private static PreparedStatement queryAll;

    static {
        try {
            var props = new Properties();
            props.load(new FileInputStream("src/main/java/mysql/mysql.ini"));
            var driver = props.getProperty("driver");
            var url = props.getProperty("url");
            var user = props.getProperty("user");
            var pass = props.getProperty("pass");
            Class.forName(driver);
            conn = DriverManager.getConnection(url, user, pass);
            insert = conn.prepareStatement("insert into img_table values (null, ?, ?)", Statement.RETURN_GENERATED_KEYS);
            query = conn.prepareStatement("select img_data from img_table where img_id = ?");
            queryAll = conn.prepareStatement("select  img_id, img_name from img_table");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    JFrame jf = new JFrame("图片管理程序");
    JFileChooser chooser = new JFileChooser(".");
    ExtensionFileFilter filter = new ExtensionFileFilter();
    private DefaultListModel<ImageHolder> imageModel = new DefaultListModel<>();
    private JList<ImageHolder> imageList = new JList<>(imageModel);
    private JTextField filePath = new JTextField(26);
    private JButton browserBn = new JButton("...");
    private JButton uploadBn = new JButton("上传");
    private JLabel imageLabel = new JLabel();

    public static void main(String[] args) {
        new BlobTest().init();
    }

    public void init() {
        filter.addExtension("jpg");
        filter.addExtension("jpeg");
        filter.addExtension("gif");
        filter.addExtension("png");
        filter.setDescription("图片文件(*.jpg, *.jpeg, *.gif, *.png)");
        chooser.addChoosableFileFilter(filter);
        chooser.setAcceptAllFileFilterUsed(false);
        fillListModel();
        filePath.setEditable(false);
        imageList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        var jp = new JPanel();
        jp.add(filePath);
        jp.add(browserBn);
        browserBn.addActionListener(event -> {
            int result = chooser.showDialog(jf, "浏览图片文件上传");
            if (result == JFileChooser.APPROVE_OPTION) {
                filePath.setText(chooser.getSelectedFile().getPath());
            }
        });
        jp.add(uploadBn);
        uploadBn.addActionListener(avt -> {
            if (filePath.getText().trim().length() > 0) {
                upload(filePath.getText());
                filePath.setText("");
            }
        });
        var left = new JPanel();
        left.setLayout(new BorderLayout());
        left.add(new JScrollPane(imageLabel), BorderLayout.CENTER);
        left.add(jp, BorderLayout.SOUTH);
        jf.add(left);
        imageList.setFixedCellWidth(160);
        jf.add(new JScrollPane(imageList), BorderLayout.EAST);
        imageList.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (e.getClickCount() >= 2) {
                    ImageHolder cur = imageList.getSelectedValue();
                    try {
                        showImage(cur.getId());
                    } catch (SQLException sqle) {
                        sqle.printStackTrace();
                    }
                }
            }
        });
        jf.setSize(620, 400);
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jf.setVisible(true);
    }

    public void fillListModel() {
        try {
            ResultSet rs = queryAll.executeQuery();
            imageModel.clear();
            while (rs.next()) {
                imageModel.addElement(new ImageHolder(rs.getInt(1), rs.getString(2)));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public void upload(String fileName) {
        String imageName = fileName.substring(fileName.lastIndexOf("/") + 1, fileName.lastIndexOf('.'));
        System.out.println(imageName);
        System.out.println(fileName);
        var f = new File(fileName);
        try {
            var is = new FileInputStream(f);
            insert.setString(1, imageName);
            insert.setBinaryStream(2, is, (int) f.length());
            int affect = insert.executeUpdate();
            if (affect == 1) {
                fillListModel();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void showImage(int id) throws SQLException {
        query.setInt(1, id);
        try {
            ResultSet rs = query.executeQuery();
            if (rs.next()) {
                Blob imgBlob = rs.getBlob(1);
                var icon = new ImageIcon(imgBlob.getBytes(1L, (int) imgBlob.length()));
                imageLabel.setIcon(icon);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

class ExtensionFileFilter extends FileFilter {
    private String description = "";
    private ArrayList<String> extensions = new ArrayList<>();

    public void addExtension(String extension) {
        if (!extension.startsWith(".")) {
            extension = "." + extension;
            extensions.add(extension.toLowerCase());
        }
    }

    @Override
    public boolean accept(File f) {
        if (f.isDirectory())
            return true;
        String name = f.getName().toLowerCase();
        for (var extension : extensions) {
            if (name.endsWith(extension)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public String getDescription() {
        return description;
    }

    public void setDescription(String aDescription) {
        description = aDescription;
    }
}

class ImageHolder {
    private int id;
    private String name;

    public ImageHolder() {
    }

    public ImageHolder(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }
}
