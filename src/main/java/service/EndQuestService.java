package service;

public class EndQuestService extends Service{
    private String url="/lose.jsp";
    private static final EndQuestService service=new EndQuestService();
    private EndQuestService() {}

    public void checkAnswer(Answer answer) {
    }
    public Service getNextStep() {
        return StartService.getService();
    }

    public String getUrl() {
        return url;
    }

    public static EndQuestService getInstance() {
        return service;
    }
}
