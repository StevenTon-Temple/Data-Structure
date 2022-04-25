package com.example.lab;

public class Rabbit extends Animal {

    public Rabbit(Model model, int row, int column) {
        super(model, row, column);
    }

    int decideMove() {
        ///this is inspired by teacher.///
        for (int i = Model.MIN_DIRECTION; i <= Model.MAX_DIRECTION; i++) {
            if (look(i) == Model.FOX) {
                if (canMove(Model.turn(i, 5))) { //<-- 5,3,1 for best direction was given during lecture but 4,6,2 where helped on by Bryan R. in what order to place them
                    return Model.turn(i, 5);
                } else if (canMove(Model.turn(i, 3))) {
                    return Model.turn(i, 3);
                } else if (canMove(Model.turn(i, 4))) {
                    return Model.turn(i, 4);
                } else if (canMove(Model.turn(i, 6))) {
                    return Model.turn(i, 6);
                } else if (canMove(Model.turn(i, 2))) {
                    return Model.turn(i, 2);
                } else if (canMove(Model.turn(i, 1))) {
                    return Model.turn(i, 1);
                }
                if (look(i)==Model.EDGE) {
                    if (!canMove(Model.turn(i, 5)) && !canMove(Model.turn(i, -3)) && !canMove(Model.turn(i, -1)) && !canMove(Model.turn(i, 3)) && !canMove(Model.turn(i, 1))) {
                        return Model.turn(i, -5);
                    } else if (!canMove(Model.turn(i, 3)) && !canMove(Model.turn(i, -5)) && !canMove(Model.turn(i, -1)) && !canMove(Model.turn(i, 5)) && !canMove(Model.turn(i, 1))) {
                        return Model.turn(i, -3);
                    } else if (!canMove(Model.turn(i, 1)) && !canMove(Model.turn(i, -3)) && !canMove(Model.turn(i, -5)) && !canMove(Model.turn(i, 3)) && !canMove(Model.turn(i, 5))) {
                        return Model.turn(i, -1);
                    }
                }
                    else if (look(i)==Model.BUSH){
                        return Model.STAY;
                    }
                }
            }

        return Model.STAY;
    }
}
