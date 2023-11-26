package service;

public class EndQuestService extends Service{
    private String url="/lose.jsp";
    private static final EndQuestService service=new EndQuestService();
    private EndQuestService() {}

    @Override
    public void checkAnswer(Answer answer) {

    }

    @Override
    public Service getNextStep() {
        return StartService.getStartService();
    }

    @Override
    public String getUrl() {
        return url;
    }

    public static EndQuestService getInstance() {
        return service;
    }
}
