package proxy.proxy3;

public class AopBrowser implements IBrowser{

    private String url;
    private Html html;

    private Runnable before;
    private Runnable after;

    public AopBrowser(String url, Runnable before, Runnable after) {
        this.url = url;
        this.before = before;
        this.after = after;
    }

    @Override
    public Html show() {

        before.run();

        if(html ==null) {
            this.html = new Html(url);
            System.out.println("AopBrowser loading html from : " + url );
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("AopBrowser use cache html : " + url );

        after.run();

        return html;
    }
}
