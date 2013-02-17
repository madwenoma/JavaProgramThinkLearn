package learn.reflection.synchronizer;

import java.util.ArrayList;

public class ProcessOne extends ProcessBase{

	private ArrayList<IStrategy> strategies = new ArrayList<IStrategy>();
	public ProcessOne(int interval, int errInterval) {
		super(interval, errInterval);
		// TODO Auto-generated constructor stub
		strategies = StrategyFactory.getStrategy(ProcessOne.class);
	}

	@Override
	public void onStarting() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onStopping() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onTick() {
		// TODO Auto-generated method stub
		for (IStrategy s : strategies) {
			s.execute();
		}
	}

}
