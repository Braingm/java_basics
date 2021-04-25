import core.Line;
import core.Station;
import junit.framework.TestCase;

import java.util.ArrayList;
import java.util.List;

public class RouteCalculatorTests extends TestCase {
    StationIndex stationIndex = new StationIndex();

    @Override
    protected void setUp() throws Exception {
        //Создание линий
        stationIndex.addLine(new Line(1, "Цветная"));
        stationIndex.addLine(new Line(2, "Фруктовая"));
        stationIndex.addLine(new Line(3, "Численная"));

        //Создание станций
        List <Station> firstLineStations = new ArrayList<>();
        firstLineStations.add(new Station("Синяя", stationIndex.getLine(1)));
        firstLineStations.add(new Station("Зелёная", stationIndex.getLine(1)));
        firstLineStations.add(new Station("Красная", stationIndex.getLine(1)));
        firstLineStations.add(new Station("Жёлтая", stationIndex.getLine(1)));
        firstLineStations.add(new Station("Фиолетовая", stationIndex.getLine(1)));
        firstLineStations.add(new Station("Серая", stationIndex.getLine(1)));
        firstLineStations.forEach(stationIndex::addStation);
        firstLineStations.forEach(stationIndex.getLine(1)::addStation);

        List <Station> secondLineStations = new ArrayList<>();
        secondLineStations.add(new Station("Грушевая", stationIndex.getLine(2)));
        secondLineStations.add(new Station("Виноградная", stationIndex.getLine(2)));
        secondLineStations.add(new Station("Яблочная", stationIndex.getLine(2)));
        secondLineStations.add(new Station("Киви", stationIndex.getLine(2)));
        secondLineStations.add(new Station("Банановая", stationIndex.getLine(2)));
        secondLineStations.add(new Station("Кокосовая", stationIndex.getLine(2)));
        secondLineStations.forEach(stationIndex::addStation);
        secondLineStations.forEach(stationIndex.getLine(2)::addStation);

        List<Station> thirdLineStations = new ArrayList<>();
        thirdLineStations.add(new Station("Первая", stationIndex.getLine(3)));
        thirdLineStations.add(new Station("Вторая", stationIndex.getLine(3)));
        thirdLineStations.add(new Station("Третья", stationIndex.getLine(3)));
        thirdLineStations.add(new Station("Четвёртая", stationIndex.getLine(3)));
        thirdLineStations.add(new Station("Пятая", stationIndex.getLine(3)));
        thirdLineStations.forEach(stationIndex::addStation);
        thirdLineStations.forEach(stationIndex.getLine(3)::addStation);

        //Создание соеденений
        List<Station> connection = new ArrayList<>();
        connection.add(stationIndex.getStation("Красная", 1));
        connection.add(stationIndex.getStation("Яблочная", 2));
        stationIndex.addConnection(connection);
        connection.clear();

        connection.add(stationIndex.getStation("Банановая", 2));
        connection.add(stationIndex.getStation("Вторая", 3));
        stationIndex.addConnection(connection);


    }

    public void testTwoConnections() {

        RouteCalculator routeCalculator = new RouteCalculator(stationIndex);
        Station from = stationIndex.getStation("Синяя");
        Station to = stationIndex.getStation("Пятая");

        var actual = routeCalculator.getShortestRoute(from, to);

        List<Station> expected = new ArrayList<>();
        expected.add(stationIndex.getStation("Синяя"));
        expected.add(stationIndex.getStation("Зелёная"));
        expected.add(stationIndex.getStation("Красная"));
        expected.add(stationIndex.getStation("Яблочная"));
        expected.add(stationIndex.getStation("Киви"));
        expected.add(stationIndex.getStation("Банановая"));
        expected.add(stationIndex.getStation("Вторая"));
        expected.add(stationIndex.getStation("Третья"));
        expected.add(stationIndex.getStation("Четвёртая"));
        expected.add(stationIndex.getStation("Пятая"));

        assertEquals(expected, actual);
    }

    public void testOneConnection(){
        RouteCalculator routeCalculator = new RouteCalculator(stationIndex);
        Station from = stationIndex.getStation("Жёлтая");
        Station to = stationIndex.getStation("Киви");

        var actual = routeCalculator.getShortestRoute(from,to);
        var actualTime = RouteCalculator.calculateDuration(actual);

        List<Station> expected = new ArrayList<>();
        expected.add(stationIndex.getStation("Жёлтая"));
        expected.add(stationIndex.getStation("Красная"));
        expected.add(stationIndex.getStation("Яблочная"));
        expected.add(stationIndex.getStation("Киви"));

        assertEquals(expected,actual);
        assertEquals(8.5 , actualTime);
    }

    public void testEqualStation(){
        RouteCalculator routeCalculator = new RouteCalculator(stationIndex);
        Station from = stationIndex.getStation("Серая");

        var actual = routeCalculator.getShortestRoute(from,from);

        var expected = new ArrayList<Station>();
        expected.add(stationIndex.getStation("Серая"));

        assertEquals(expected, actual);
    }

}
