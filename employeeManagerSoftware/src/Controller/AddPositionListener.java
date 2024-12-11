package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import View.PositionManagement_AddPosition;

public class AddPositionListener implements ActionListener{

	private PositionManagement_AddPosition pmap;
	
	public AddPositionListener(PositionManagement_AddPosition pmap) {
		super();
		this.pmap = pmap;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		pmap.add_position();
	}

}
