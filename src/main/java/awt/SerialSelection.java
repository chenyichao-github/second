package awt;

import org.jetbrains.annotations.NotNull;

import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.Transferable;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.io.IOException;
import java.io.Serializable;

public class SerialSelection implements Transferable {
    private Serializable obj;

    public SerialSelection(Serializable obj) {
        this.obj = obj;
    }

    @Override
    public DataFlavor[] getTransferDataFlavors() {
        var flavors = new DataFlavor[2];
        Class clazz = obj.getClass();
        try {
            flavors[0] = new DataFlavor(DataFlavor.javaSerializedObjectMimeType + ";class=" + clazz.getName());
            flavors[1] = DataFlavor.stringFlavor;
            return flavors;
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public boolean isDataFlavorSupported(DataFlavor flavor) {
        return flavor.equals(DataFlavor.stringFlavor) || flavor.getPrimaryType().equals("application") && flavor.getSubType().equals("x-java-serialized-object") && flavor.getRepresentationClass().isAssignableFrom(obj.getClass());
    }

    @NotNull
    @Override
    public Object getTransferData(DataFlavor flavor) throws UnsupportedFlavorException, IOException {
        if (!isDataFlavorSupported(flavor)) {
            throw new UnsupportedFlavorException(flavor);
        }
        if (flavor.equals(DataFlavor.stringFlavor)) {
            return obj.toString();
        }
        return obj;
    }
}
