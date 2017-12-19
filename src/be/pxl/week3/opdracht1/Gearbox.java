package be.pxl.week3.opdracht1;

import java.util.ArrayList;

public class Gearbox {
	private int maxGears;
	private boolean clutchIsIn;
	private Gear currentGear;
	private ArrayList<Gear> gears = new ArrayList<Gear>();
	
	public Gearbox(int maxGears) {
		this.maxGears = maxGears;
		
		for (int i = 0; i < maxGears; i++) {
			addGear(new Gear(i+1));
		}
	}
	
	public void operateClutch(boolean isIn) {
		clutchIsIn = isIn;
	}
	
	public void addGear(Gear gear) {
		gears.add(gear);
	}
	
	public void changeGear(int newGear) {
		if (newGear <= maxGears && clutchIsIn) {
			for (Gear gear : gears) {
				if (gear.gearNumber == newGear) {
					currentGear = gear;
					break;
				}
			}
			System.out.println("Gear " + newGear + " selected");
		} else {
			System.out.println("Vreemd geluid");
			currentGear = null;
		}
	}
	
	public double wheelSpeed(int revs) {
		if (clutchIsIn || currentGear == null) {
			return 0;
		}
		return currentGear.driveSpeed(revs);
	}
	
	private class Gear {
		private int gearNumber;
		private double ratio;
		
		public Gear(int gearNumber) {
			this.gearNumber = gearNumber;
			ratio = gearNumber * 5.3;
		}
		
		public double driveSpeed(int revs) {
			return revs * ratio;
		}
		
	}

}
