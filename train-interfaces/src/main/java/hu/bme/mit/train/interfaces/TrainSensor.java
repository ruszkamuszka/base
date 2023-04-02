package hu.bme.mit.train.interfaces;

import java.time.LocalDate;
import java.util.Date;
import java.util.Locale;

public interface TrainSensor {

	int getSpeedLimit();

	void overrideSpeedLimit(int speedLimit);

	void tachoGraphInsert();
	int tachoGraphGet(LocalDate row, Integer column);

}
