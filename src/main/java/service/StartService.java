package service;
public class StartService extends Service {
    private static final StartService startService=new StartService();
    private String url="/start.jsp";
    private Service nextStep;
    private StartService() {
    }
    public static StartService getStartService() {
        return startService;
    }

    public Service getNextStep() {
        return nextStep;
    }
    public String getUrl() {
        return url;
    }

    public void checkAnswer(Answer answer) {
        if(answer.getText().equals("reject")) {
            nextStep=EndQuestService.getInstance();
        } else {
            nextStep=CaptainBridgeService.getInstance();
        }

    }
}
