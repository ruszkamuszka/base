package hu.bme.mit.train.sensor;

import hu.bme.mit.train.interfaces.TrainController;
import hu.bme.mit.train.interfaces.TrainSensor;
import hu.bme.mit.train.interfaces.TrainUser;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.time.LocalDate;

import static org.mockito.Mockito.*;

public class TrainSensorTest {
    TrainSensorImpl trainSensor;
    TrainUser trainUser;
    TrainController trainController;
    @Before
    public void before() {
        trainController = mock(TrainController.class);
        trainUser = mock(TrainUser.class);
        trainSensor = new TrainSensorImpl(trainController, trainUser);
    }

    @Test
    public void TachoTest() {

    }

    @Test
    public void SpeedLimitTest1(){
        trainSensor.overrideSpeedLimit(501);
        verify(trainUser, times(1)).setAlarmState(true);
    }

    @Test
    public void SpeedLimitTest2(){
        when(trainController.getReferenceSpeed()).thenReturn(15);
        trainSensor.overrideSpeedLimit(10);
        verify(trainUser, times(1)).setAlarmState(false);
    }

    @Test
    public void SpeedLimitTest3(){
        trainSensor.overrideSpeedLimit(-1);
        trainSensor.overrideSpeedLimit(501);
        verify(trainUser, times(2)).setAlarmState(true);
    }

    @Test
    public void SpeedLimitTest4(){
        trainSensor.overrideSpeedLimit(300);
        verify(trainUser, times(1)).setAlarmState(false);
    }

    @Test
    public void SpeedLimitTest5(){
        when(trainController.getReferenceSpeed()).thenReturn(15);
        trainSensor.overrideSpeedLimit(1);
        verify(trainUser, times(1)).setAlarmState(true);
    }


}
