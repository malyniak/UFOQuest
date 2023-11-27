package service;
public class StartService extends Service {
    private static final StartService service=new StartService();
    private String url="/start.jsp";
    private Service nextStep;
    private StartService() {
    }
    public static StartService getService() {
        return service;
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
            nextStep=CaptainBridgeService.getService();
        }

    }
}
