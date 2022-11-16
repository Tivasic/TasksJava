package laboratory3;

import java.util.HashMap;

/**
 * Этот класс хранит базовое состояние, необходимое для алгоритма A* для вычисления
 * пути на карте. Это состояние включает в себя коллекцию "открытых путевых точек" и
 * другую коллекцию "закрытых путевых точек". Кроме того, этот класс обеспечивает
 * основные операции, необходимые алгоритму поиска пути A* для его выполнения.
 **/
public class AStarState {
    /**
     * Это ссылка на карту, по которой перемещается алгоритм A*.
     **/
    private final Map2D map;
    private final HashMap<Location, Waypoint> closedWaypoints;
    private final HashMap<Location, Waypoint> openWaypoints;


    /**
     * Инициализация нового объекта состояния для использования алгоритма поиска пути A*.
     **/
    public AStarState(Map2D map) {
        if (map == null)
            throw new NullPointerException("map cannot be null");

        this.map = map;
        this.closedWaypoints = new HashMap<>();
        this.openWaypoints = new HashMap<>();
    }

    /**
     * Возвращает карту, по которой перемещается навигатор A*.
     **/
    public Map2D getMap() {
        return map;
    }

    /**
     * Этот метод сканирует все открытые путевые точки и возвращает путевую точку
     * с минимальной общей стоимостью. Если открытых путевых точек нет, этот метод
     * возвращает null.
     **/
    public Waypoint getMinOpenWaypoint() {
        if (openWaypoints.isEmpty())
            return null;
        return openWaypoints.values().stream()
                .min((w1, w2) -> Float.compare(w1.getTotalCost(), w2.getTotalCost()))
                .get();
    }

    /**
     * Этот метод добавляет путевую точку к (или потенциально обновляет уже имеющуюся путевую точку)
     * коллекции "открытые путевые точки". Если еще не существует открытой
     * путевой точки в местоположении новой путевой точки, тогда новая путевая точка просто
     * добавляется в коллекцию. Однако, если в местоположении новой путевой точки уже есть путевая точка,
     * новая путевая точка заменяет только старую. Если значение "предыдущей стоимости" новой путевой точки
     * меньше текущего, то значение "предыдущей стоимости" перезаписывается.
     **/
    public boolean addOpenWaypoint(Waypoint newWP) {
        Location loc = newWP.getLocation();
        if (!openWaypoints.containsKey(loc)) {
            openWaypoints.put(loc, newWP);
            return true;
        }

        Waypoint oldWP = openWaypoints.get(loc);
        if (Float.compare(newWP.getPreviousCost(), oldWP.getPreviousCost()) < 0) {
            openWaypoints.put(loc, newWP);
            return true;
        }
        return false;
    }


    /**
     * Возвращает текущее количество открытых путевых точек.
     **/
    public int numOpenWaypoints() {
        return openWaypoints.size();
    }


    /**
     * Этот метод перемещает путевую точку в указанном местоположении из
     * открытого списка в закрытый список.
     **/
    public void closeWaypoint(Location loc) {
        Waypoint wp = openWaypoints.remove(loc);
        closedWaypoints.put(loc, wp);
    }

    /**
     * Возвращает значение true, если коллекция закрытых путевых точек содержит путевую точку
     * для указанного местоположения.
     **/
    public boolean isLocationClosed(Location loc) {

        return closedWaypoints.containsKey(loc);
    }
}

