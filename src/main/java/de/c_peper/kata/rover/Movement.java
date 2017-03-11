package de.c_peper.kata.rover;

@lombok.RequiredArgsConstructor
enum Movement {
    NORTH(0, 1),
    WEST(-1, 0),
    SOUTH(0, -1),
    EAST(1, 0);

    final int x;
    final int y;
}
