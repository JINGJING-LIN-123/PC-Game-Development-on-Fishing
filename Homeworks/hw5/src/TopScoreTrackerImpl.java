public class TopScoreTrackerImpl implements TopScoreTracker {
    private int topM;
    public OrderedList<Run>[] mList;

    public TopScoreTrackerImpl(int monthlyTopN, int yearlyTopM) {
        mList = new OrderedListImpl[12];
        for(int i = 0; i < 12; i++) {
            mList[i] = new OrderedListImpl<Run>(monthlyTopN);
        }
        topM = yearlyTopM;
    }

    @Override
    public void addRun(int m, Run r) {
        if(m < 1 || m > 12) {
            throw new IllegalArgumentException();
        }
        mList[m-1].add(r);
    }

    @Override
    public String annualReport() {
        OrderedList<Run> yList = new OrderedListImpl<Run>(0);
        for(int i = 0; i < 12; i++) {
            yList = yList.merge(mList[i]);
        }
        yList.resize(topM);
        return yList.toString();
    }

    @Override
    public String toString() {
        String result = "";
        for (int i = 0; i < 12; i++) {
            result += i + ": " + mList[i].toString() + '\n';
        }
        return result;
    }
}
