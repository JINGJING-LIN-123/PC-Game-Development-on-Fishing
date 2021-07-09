public class TopScoreTrackerImpl implements TopScoreTracker {
    private int topM;
    private OrderedList[] mList;

    public TopScoreTrackerImpl(int monthlyTopN, int yearlyTopM) {
        mList = new OrderedListImpl[12];
        for(int i = 0; i < 12; i++) {
            mList[i] = new OrderedListImpl(monthlyTopN);
        }
        topM = yearlyTopM;
    }

    @Override
    public void addRun(int m, Run r) {
        if(m < 0 || m >= 12) {
            throw new IllegalArgumentException();
        }
        mList[m].add(r);
    }

    @Override
    public String annualReport() {
        OrderedList<Run> yList = new OrderedListImpl(0);
        for(int i = 0; i < 12; i++) {
            yList.merge(mList[i]);
        }
        yList.resize(topM);
        return yList.toString();
    }
}

