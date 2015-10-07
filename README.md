# Точки

## Условия задачи:
Даны N точек на плоскости (для простоты можно считать, что у всех точек целочисленные координаты). Назовём расстояние от точки A до ближайшей к ней точки B "радиусом" точки A. "Соседями" точки A будем называть все точки, лежащие в пределах двойного радиуса от неё включительно (кроме самой точки A).
Для каждой точки из заданного набора определите её радиус и количество соседей.

## Суть метода:
Задача решена методом посторения VP-дерева с математической сложностью `n*log n`.

Для каждой точки (исходная точка):

1. Вычисляем расстояние до всех остальных точек.
2. Строим VP-дерево, в котором верхняя вершина содержит все точки, листы - точка или несколько равноудаленных точек от исходной, все листы упорядоченны слева направо по удаленности от исходной. Точка в крайнем левом листе - самая ближняя к исходной.
3. Вычисляем радиус - расстояние от самой ближайшей точки до исходной.
4. Обходим все листья дерева слева направо и находим все точки, которые находятся в пределах двойного радиуса, включая границу.

## Инструкция по использованию приложения:
1. Указываем исходные данные о точках в файле `~/src/main/resources/source.json` в предложенном формате JSON.
2. Запускаем класс Run.
