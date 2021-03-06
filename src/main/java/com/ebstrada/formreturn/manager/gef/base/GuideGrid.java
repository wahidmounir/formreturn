package com.ebstrada.formreturn.manager.gef.base;

import java.awt.Point;

/**
 * Constrains interactions to certain coordinates. In this case, GuideGrid makes
 * objects snap to a grid. Note that GuideGrid is an invisible object that
 * controls the behavior of the Editor and Modes. It is conceptually related to
 * the visible grid (implemented in LayerGrid), but there is no functional
 * relationship between them in this framework.
 */

public class GuideGrid extends Guide {

    private static final long serialVersionUID = -8729481663081674989L;

    /**
     * Size of the grid.
     */
    protected int _gridSize = 8;

    // //////////////////////////////////////////////////////////////
    // constructors

    /**
     * Make a new GuideGrid instance with the given grid size.
     */
    public GuideGrid(int size) {
        _gridSize = size;
    }

    // //////////////////////////////////////////////////////////////
    // accessors

    /**
     * Reply the size of the grid to snap points to.
     */
    public int gridSize() {
        return _gridSize;
    }

    /**
     * Set the size of the grid.
     */
    public void gridSize(int g) {
        _gridSize = g;
    }

    // //////////////////////////////////////////////////////////////
    // Guide API

    /**
     * Modify the given point to be on the guideline (In this case, a gridline)
     */
    @Override public void snap(Point p) {
        p.x = (p.x + _gridSize / 2) / _gridSize * _gridSize;
        p.y = (p.y + _gridSize / 2) / _gridSize * _gridSize;
    }

    // //////////////////////////////////////////////////////////////
    // user interface

    /**
     * Bring up a dialog box to set the grid snap parameters. Needs-More-Work:
     * use the property sheet to change guide parameters.
     */
    @Override public void adjust() {
        if (_gridSize >= 32) {
            _gridSize = 4;
        } else {
            _gridSize *= 2;
        }
    }
} /* end class GuideGrid */
