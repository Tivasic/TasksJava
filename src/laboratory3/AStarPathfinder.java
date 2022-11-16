package laboratory3;

/**
 * Этот класс содержит реализацию алгоритма поиска пути A*. Алгоритм
 * реализован как статический метод, поскольку алгоритм поиска пути
 * на самом деле не нужно поддерживать какое-либо состояние между вызовами алгоритма.
 */
public class AStarPathfinder {
    /**
     * Эта константа содержит максимальный предел отсечения для стоимости путей. Если
     * конкретная путевая точка превышает этот лимит затрат, путевая
     * точка отбрасывается.
     **/
    public static final float COST_LIMIT = 1e6f;


    /**
     * Вычисление пути, который перемещается между начальным и конечным
     * местоположениями указанной карты. Если путь может быть найден, возвращается путевая точка
     * последнего шага пути; эта путевая точка может быть
     * использована для обратного перехода к начальной точке. Если путь не может быть найден, возвращается null.
     **/
    public static Waypoint computePath(Map2D map) {
        // Переменные, необходимые для поиска A*.
        AStarState state = new AStarState(map);
        Location finishLoc = map.getFinish();

        // Устанавливаем начальную путевую точку, чтобы начать поиск A*.
        Waypoint start = new Waypoint(map.getStart(), null);
        start.setCosts(0, estimateTravelCost(start.getLocation(), finishLoc));
        state.addOpenWaypoint(start);

        Waypoint finalWaypoint = null;
        boolean foundPath = false;

        while (!foundPath && state.numOpenWaypoints() > 0) {
            // Ищем "лучшую" (т.е. самую дешевую) точку маршрута на данный момент.
            Waypoint best = state.getMinOpenWaypoint();

            // Если лучшее место - это место финиша, то мы закончили!
            if (best.getLocation().equals(finishLoc)) {
                finalWaypoint = best;
                foundPath = true;
            }

            // Добавляем или обновляем всех соседей текущего наилучшего местоположения. Это
            // эквивалентно попытке выполнить все "следующие шаги" из этого местоположения.
            takeNextStep(best, state);

            // Перемещаем это местоположение из списка "открыто" в список "закрыто".
            state.closeWaypoint(best.getLocation());
        }

        return finalWaypoint;
    }

    /**
     * Этот статический вспомогательный метод принимает путевую точку и генерирует все допустимые следующие
     * шаги от этой точки маршрута. Новые путевые точки добавляются в коллекцию открытых путевых точек.
     **/
    private static void takeNextStep(Waypoint currWP, AStarState state) {
        Location loc = currWP.getLocation();
        Map2D map = state.getMap();

        for (int y = loc.yCoord - 1; y <= loc.yCoord + 1; y++) {
            for (int x = loc.xCoord - 1; x <= loc.xCoord + 1; x++) {
                Location nextLoc = new Location(x, y);

                // Если следующее местоположение находится за пределами карты, пропустите его.
                if (!map.contains(nextLoc))
                    continue;

                // Если следующее точка - текущая точка, то пропускаем ее.
                if (nextLoc == loc)
                    continue;

                // Если эта точка уже находится в "закрытом" наборе,
                // то переходим к следующей
                if (state.isLocationClosed(nextLoc))
                    continue;

                Waypoint nextWP = new Waypoint(nextLoc, currWP);

                // Используем смету затрат для вычисления фактической
                // стоимости из предыдущей ячейки. Затем мы добавляем стоимость из
                // ячейки карты, на которую мы наступаем, чтобы включить барьеры и т.д.

                float prevCost = currWP.getPreviousCost() +
                        estimateTravelCost(currWP.getLocation(),
                                nextWP.getLocation());

                prevCost += map.getCellValue(nextLoc);

                // Пропускаем следующую точку, если это слишком дорого.
                if (prevCost >= COST_LIMIT)
                    continue;

                nextWP.setCosts(prevCost,
                        estimateTravelCost(nextLoc, map.getFinish()));

                // Добавляем точку в набор открытых путевых точек. Если там
                // уже есть точка для этого местоположения, новая
                // точка заменяет старую точку только в том случае, если это менее затратно.
                state.addOpenWaypoint(nextWP);
            }
        }
    }

    /**
     * Оценивает стоимость пути между двумя указанными точками.
     * Рассчитанная фактическая стоимость - это расстояние по прямой между двумя точками.
     **/
    private static float estimateTravelCost(Location currLoc, Location destLoc) {
        int dx = destLoc.xCoord - currLoc.xCoord;
        int dy = destLoc.yCoord - currLoc.yCoord;

        return (float) Math.sqrt(dx * dx + dy * dy);
    }
}
