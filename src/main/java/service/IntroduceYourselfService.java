package service;

public class IntroduceYourselfService extends Service {
    private static final IntroduceYourselfService service = new IntroduceYourselfService();
    private String url = "/introduce.jsp";
    private Service nextStep;

    public Service getNextStep() {
        return nextStep;
    }

    private IntroduceYourselfService() {
    }

    public String getUrl() {
        return url;
    }

    public static IntroduceYourselfService getService() {
        return service;
    }

    public void checkAnswer(Answer answer) {
        if (answer.getText().equals("lie")) {
            nextStep = EndQuestService.getInstance();
        } else {
            nextStep = WinService.getService();
        }

    }
}
