package com.skilldistillery.jets;

import java.util.Scanner;

public class JetsApplication {
	Scanner kb = new Scanner(System.in);

	public JetsApplication() {
	}

	public void run() {
		Scanner kb = new Scanner(System.in);
		Jet[] jets = new Jet[50];
		//creates arbitrary jets
		JetsApplication j = new JetsApplication();
		FighterJet jet1 = new FighterJet("F-14", 656, 1544, 1200000);
		JetImpl jet2 = new JetImpl("BoringPlane", 590, 6000, 750000);
		CargoPlane cargoJet = new CargoPlane("Cargo Jet", 550, 3900, 850000);
		CargoPlane cargoPlane2 = new CargoPlane("Other Cargo Plane", 490, 4400, 875000);
		FighterJet jet3 = new FighterJet("F-16", 750, 1866, 1900000);

		jets[1] = jet1;
		jets[2] = jet2;
		jets[3] = cargoJet;
		jets[4] = cargoPlane2;
		jets[5] = jet3;
		AirField airField = new AirField(jets);
		
		//switch statment for crude user menu
		while (true) {
			int choice = j.displayUserMenu(kb);
			switch (choice) {
			case 1:
				displayAllJets(jets);
				break;
			case 2:
				flyAllJets(jets);
				break;
			case 3:
				displayFastsetJet(jets);
				break;
			case 4:
				displayLongestRange(jets);
				break;
			case 5:
				loadAllJets(jets);
				break;
			case 6:
				dogfight();
				break;
			case 7:
				addJet(jets, kb);
				break;
			case 8:
				System.exit(0);

			}

		}
	}

	public int displayUserMenu(Scanner kb) {
		System.out.println("Welcome to the airField AirField!\n" + "[1] - List Fleet\n" + "[2] - Fly ALL jets\n"
				+ "[3] - Display fastest jet\n" + "[4] - Display jet with longest range\n"
				+ "[5] - Load ALL Cargo Jets\n" + "[6] - Dogfight\n" + "[7] - Add a jet to the fleet" + "\n[8] - Exit");
		int choice = kb.nextInt();
		return choice;

	}
	public void dogfight() {
		
	}

	public void displayAllJets(Jet[] jets) {
		for (int i = 0; i < jets.length; i++) {
			if (jets[i] == null) {
				continue;
			}
			System.out.println(jets[i].toString());

		}

	}

	public void loadAllJets(Jet[] jets) {
		for (int i = 0; i < jets.length; i++) {
			if (jets[i] == null) {
				continue;

			}
			if (jets[i] instanceof CargoCarrier) {
				System.out.println(jets[i].getModel() + ": -- ");
				CargoCarrier.loadCargo();
				continue;
			}
		}

	}

	public Jet[] flyAllJets(Jet[] jets) {
		for (int i = 0; i < jets.length; i++) {
			if (jets[i] == null) {
				continue;
			}
			jets[i].fly();

		}
		return jets;
	}

	public void displayFastsetJet(Jet[] jets) {
		double tempSpeed = 0;
		Jet tempJet = null;
		for (int i = 0; i < jets.length; i++) {
			if (jets[i] == null) {
				continue;
			}
			if (jets[i].getSpeed() > tempSpeed) {
				tempSpeed = jets[i].getSpeed();
				tempJet = jets[i];
			}

		}
		System.out.println(tempJet.toString());

	}

	public void displayLongestRange(Jet[] jets) {
		double tempRange = 0;
		Jet tempJet = null;
		for (int i = 0; i < jets.length; i++) {
			if (jets[i] == null) {
				continue;
			}
			if (jets[i].getRange() > tempRange) {
				tempRange = jets[i].getSpeed();
				tempJet = jets[i];
			}

		}
		System.out.println(tempJet.toString());

	}

	public Jet[] addJet(Jet[] jets, Scanner kb) {
		String model;
		double speed;
		int range;
		long price;
		System.out.println("OK lets get that new jet in there!\n\n");
		System.out.println("What is the model of the jet?");

		// buffer flush
		kb.nextLine();
		model = kb.nextLine();
		System.out.println("Ok! What is the speed of the jet in MPH?");
		speed = kb.nextDouble();
		System.out.println("Ok! What is the range?");
		range = kb.nextInt();
		System.out.println("Ok! What is the price of the jet?");
		price = kb.nextLong();

		JetImpl newJet = new JetImpl(model, speed, range, price);

		for (int i = 0; i < jets.length; i++) {
			if (jets[i] != null) {
				continue;
			} else {
				jets[i] = newJet;
				break;
			}
		}

		return jets;
	}

}
