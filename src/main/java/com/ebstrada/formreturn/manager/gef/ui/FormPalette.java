package com.ebstrada.formreturn.manager.gef.ui;

import java.awt.Dimension;

import javax.swing.Action;
import javax.swing.ButtonGroup;
import javax.swing.JToggleButton;
import javax.swing.JToolBar;
import javax.swing.border.EmptyBorder;

import com.ebstrada.formreturn.manager.gef.base.ModeCreateFigBarcode;
import com.ebstrada.formreturn.manager.gef.base.ModeCreateFigCircle;
import com.ebstrada.formreturn.manager.gef.base.ModeCreateFigImage;
import com.ebstrada.formreturn.manager.gef.base.ModeCreateFigLine;
import com.ebstrada.formreturn.manager.gef.base.ModeCreateFigRRect;
import com.ebstrada.formreturn.manager.gef.base.ModeCreateFigRect;
import com.ebstrada.formreturn.manager.gef.base.ModeCreateFigSegment;
import com.ebstrada.formreturn.manager.gef.base.ModeCreateFigText;
import com.ebstrada.formreturn.manager.gef.base.ModeSelect;
import com.ebstrada.formreturn.manager.gef.base.SetModeAction;
import com.ebstrada.formreturn.manager.gef.util.Localizer;

public class FormPalette extends Palette {

    private static final long serialVersionUID = 1L;

    ButtonGroup group;

    public FormPalette() {
        super(Palette.VERTICAL);
        defineButtons();
    }

    public JToggleButton addToggle(Action a, String toolTip) {
        JToggleButton button = super.addToggle(a);
        button.setMinimumSize(new Dimension(140, 26));
        button.setPreferredSize(new Dimension(140, 26));
        button.setToolTipText(Localizer.localize("GefBase", toolTip));
        button.setText(Localizer.localize("GefBase", (String) a.getValue(Action.NAME)));
        return button;
    }

    @Override public void defineButtons() {

        group = new ButtonGroup();

        group.add(addToggle(new SetModeAction(ModeSelect.class, "Select"), "SelectTip"));
        addSeparator();
        group.add(addToggle(new SetModeAction(ModeCreateFigCircle.class, "Circle"), "CircleTip"));
        group.add(
            addToggle(new SetModeAction(ModeCreateFigRect.class, "Rectangle"), "RectangleTip"));
        group.add(addToggle(new SetModeAction(ModeCreateFigRRect.class, "RRect"), "RRectTip"));
        group.add(addToggle(new SetModeAction(ModeCreateFigLine.class, "Line"), "LineTip"));
        group.add(addToggle(new SetModeAction(ModeCreateFigText.class, "Text"), "TextTip"));
        group.add(addToggle(new SetModeAction(ModeCreateFigImage.class, "Image"), "ImageTip"));
        group
            .add(addToggle(new SetModeAction(ModeCreateFigSegment.class, "Segment"), "SegmentTip"));
        group
            .add(addToggle(new SetModeAction(ModeCreateFigBarcode.class, "Barcode"), "BarcodeTip"));

    }
}
