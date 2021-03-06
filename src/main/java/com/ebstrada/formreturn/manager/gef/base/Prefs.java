package com.ebstrada.formreturn.manager.gef.base;

import java.awt.Color;

import com.ebstrada.formreturn.manager.gef.presentation.Fig;

/**
 * This class contains preferences that control the behavior of the editor to
 * make it the way that the user likes it. Needs-More-Work: more of the
 * frame-rate could be self-adusting, not a preference. Needs-More-Work: more of
 * this should move into RedrawManager.
 */

public class Prefs {

    /**
     * Construct a new Prefs instance
     */
    public Prefs() {

    }

    /**
     * Reply the color that should be used for rubberband lines.
     */
    public Color getRubberbandColor() {
        return new Color(0x33, 0x33, 0x99);
    }

    /**
     * The color of the handles used to manipulate Fig's
     */
    private Color _handleColor = new Color(0x55, 0x55, 0xaa);

    /**
     * The color of the handles used to indicate locked Fig's
     */
    private Color _lockedHandleColor = new Color(0x55, 0x55, 0x55);

    /**
     * The color of the handles used to manipulate Fig's
     */
    public Color handleColorFor(Fig f) {
        if (f.getLocked()) {
            return _lockedHandleColor;
        } else {
            return _handleColor;
        }
    }

    /**
     * The color of the handles used to manipulate Fig's
     */
    public void setHandleColor(Color c) {
        _handleColor = c;
    }

    public Color getHandleColor() {
        return _handleColor;
    }

    /**
     * The color of the handles used to manipulate Fig's
     */
    public void setLockedHandleColor(Color c) {
        _lockedHandleColor = c;
    }

    public Color getLockedHandleColor() {
        return _lockedHandleColor;
    }

    /**
     * The color of the highlight shown to draw the users attention
     */
    Color _highlightColor = new Color(0xAA, 0x55, 0x55);

    /**
     * The color of the highlight shown to draw the users attention
     */
    public Color getHighlightColor() {
        return _highlightColor;
    }

    /**
     * The color of the highlight shown to draw the users attention
     */
    public void setHighlightColor(Color c) {
        _highlightColor = c;
    }

    /**
     * True if LayerGrid should appear in printouts.
     */
    protected boolean _printGrid = false;

    public boolean getPrintGrid() {
        return _printGrid;
    }

    public void setPrintGrid(boolean b) {
        _printGrid = b;
    }

    /**
     * True if background Layers should appear in printouts.
     */
    protected boolean _printBackground = false;

    public boolean getPrintBackground() {
        return _printBackground;
    }

    public void setPrintBackground(boolean b) {
        _printBackground = b;
    }

    /**
     * Times used to fine-tune redrawing behavior
     */
    private long _redrawTimeThreshold = 500, _lastRedrawTime;

    /**
     * Set the last redraw time. Called from a RedrawManager. Should this be
     * inside RedrawManager? What if there are multiple RedrawManager's?
     */
    public void lastRedrawTime(long t) {
        _lastRedrawTime = t;
    }

    /**
     * if the time between redraws gets longer than this threshold, then switch
     * to a faster redrawing method, at the expense of quality and/or flicker
     */
    public void setRedrawTimeThreshold(long t) {
        _redrawTimeThreshold = t;
    }

    /**
     * Defines a default about whether the slow, flicker-free redraw method
     * should be used, or the fast, flicker-full one. By defualt uses,
     * flicker-free, except on JDK 1.0.2 on Sun's appletviewer for Windows.
     * Needs-More-Work: should be a PARAM.
     */
    private boolean _tryOffScreen =
        !(System.getProperty("java.vendor").equals("Sun Microsystems Inc.") && System
            .getProperty("java.version").equals("102") && System.getProperty("os.name")
            .startsWith("Win"));

    /**
     * Should off screen images be used to reduce flicker? This is not the
     * default behavior because some (beta) versions of WWW browsers do not
     * handle off screen images well.
     */
    public void setTryOffScreen(boolean b) {
        _tryOffScreen = b;
    }

    /**
     * Should off screen images be used to reduce flicker?
     */
    public boolean getTryOffScreen() {
        return _tryOffScreen;
    }

    /**
     * Determine if the next redraw should be done on screen or offscreen. If
     * the last redraw was fast, then try this one with less flicker.
     * Needs-More-Work: this code should be in RedrawManager.
     */
    public boolean shouldPaintOffScreen() {
        if (_tryOffScreen) {
            return _lastRedrawTime < _redrawTimeThreshold;
        } else {
            return false;
        }
    }

} /* end class Prefs */
