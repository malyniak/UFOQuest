package service;

public class WinService extends Service{
    private String url="/win.jsp";
    private static final WinService service=new WinService();
    private WinService() {}

    @Override
    public void checkAnswer(Answer answer) {

    }

    public Service getNextStep() {
        return StartService.getStartService();
    }
    @Override
    public String getUrl() {
        return url;
    }

    public static WinService getInstance() {
        return service;
    }
}
