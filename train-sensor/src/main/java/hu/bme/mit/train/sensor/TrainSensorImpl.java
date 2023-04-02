package hu.bme.mit.train.sensor;

import com.google.common.collect.HashBasedTable;
import com.google.common.collect.Table;
import hu.bme.mit.train.interfaces.TrainController;
import hu.bme.mit.train.interfaces.TrainSensor;
import hu.bme.mit.train.interfaces.TrainUser;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

public class TrainSensorImpl implements TrainSensor {

	private TrainController controller;
	private TrainUser user;
	private int speedLimit = 5;
	Table<LocalDate, Integer, Integer> tachoGraph
			= HashBasedTable.create();

	public TrainSensorImpl(TrainController controller, TrainUser user) {
		this.controller = controller;
		this.user = user;
	}

	@Override
	public int getSpeedLimit() {
		return speedLimit;
	}

	@Override
	public void overrideSpeedLimit(int speedLimit) {
		this.speedLimit = speedLimit;
		controller.setSpeedLimit(speedLimit);
	}

	@Override
	public void tachoGraphInsert() {
		tachoGraph.put(LocalDate.now(), user.getJoystickPosition(), controller.getReferenceSpeed());
	}
	@Override
	public int tachoGraphGet(LocalDate row, Integer column){
		int searched = tachoGraph.get(row, column);
		return searched;
	}

}
