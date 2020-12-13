package thread;

import java.util.List;
import java.util.concurrent.Flow.Subscriber;
import java.util.concurrent.Flow.Subscription;
import java.util.concurrent.SubmissionPublisher;

/**
 * Description:<br>
 * 网站: <a href="http://www.crazyit.org">疯狂Java联盟</a><br>
 * Copyright (C), 2001-2020, Yeeku.H.Lee<br>
 * This program is protected by copyright laws.<br>
 * Program Name:<br>
 * Date:<br>
 *
 * @author Yeeku.H.Lee kongyeeku@163.com<br>
 * @version 5.0
 */
public class PubSubTest {
    public static void main(String[] args) {
        SubmissionPublisher<String> publisher = new SubmissionPublisher<>();
        MySubscriber<String> subscriber = new MySubscriber<>();
        publisher.subscribe(subscriber);
        System.out.println("开发发布数据...");
        List.of("Java", "Kotlin", "Go", "Erlang", "Swift", "Lua").forEach(im -> {
            publisher.submit(im);
            try {
                Thread.sleep(500);
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        });
        publisher.close();
        synchronized ("fkjava") {
            try {
                "fkjava".wait();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }
}

class MySubscriber<T> implements Subscriber<T> {
    private Subscription subscription;

    @Override
    public void onSubscribe(Subscription subscription) {
        this.subscription = subscription;
        subscription.request(1);
    }

    @Override
    public void onNext(T item) {
        System.out.println("获取到数据: " + item);
        subscription.request(1);
    }

    @Override
    public void onError(Throwable t) {
        t.printStackTrace();
        synchronized ("fkjava") {
            "fkjava".notifyAll();
        }
    }

    @Override
    public void onComplete() {
        System.out.println("订阅结束");
        synchronized ("fkjava") {
            "fkjava".notifyAll();
        }
    }
}
