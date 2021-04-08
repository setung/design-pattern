package proxy.proxy1;

public class Proxy implements Subject{

    private Subject subject;

    public Proxy(Subject subject) {
        this.subject = subject;
    }

    @Override
    public void action1() {
        System.out.println("간단 업무 by Proxy");
    }

    @Override
    public void action2() {
        subject.action2();
    }
}
