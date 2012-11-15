package com.sensorgateway;


public  class Room {
	
	public static int MAX_ROOMS = 50;
	public static Room[] Rooms = new Room[MAX_ROOMS];
	public static int roomCount = 0;
	
	public int RoomID;
	public String RoomName;
	public SensorPoints sensorPoint;
	public Temperature temperature = null;
	
	public String LightValue;
	public String PressureValue;
		
	public enum ROOMS
	{
		Room106,Room107,Room108,Room109,Room110,RoomW,RoomStairs,
		RoomM,Room121,RoomKitchen,Room118,Room117,Room117L,
		Room120,Room122,Room123,Room126,RoomLobby,Room104,
		Room105,Room129,Room129M,Room129A,Room129B,Room111,
		Room112,Room113,Room114,Room115,Room116,Room119,
		Room124,Room125,Room127,Room128
	}
		
	public static Room CreateRoom(bldgdata data)
	{
		Rooms[++roomCount] = new Room();
		Rooms[roomCount].RoomName = data.name;
		Rooms[roomCount].temperature = new Temperature(data.centigrade);
		Rooms[roomCount].RoomID = Integer.parseInt(data.localityID);
		Rooms[roomCount].sensorPoint = Rooms[roomCount].getSensorPoints(Rooms[roomCount].RoomID);
		return Rooms[roomCount];
	}
	
	public void setRoomdata(bldgdata data)
	{
		RoomName = data.name;
		temperature = new Temperature(data.centigrade);
		LightValue = data.lux;
		PressureValue = data.kPascals;
	}
	
	/*public int getRoomLength(int roomID)
	{
		switch(ROOMS.values()[roomID])
		{
		case Room106:
			return 10;
		case Room107:
			return 10;				
		case Room108:
			return 10;				
		case Room109:
			return 10;				
		case Room110:
			return 10;				
		case Room111:
			return 10;				
		case Room112:
			return 10;				
		case Room113:
			return 10;				
		case Room114:
			return 10;				
		case Room115:
			return 10;				
		case Room116:
			return 10;				
		case RoomW:
			return 10;				
		case RoomStairs:
			return 10;				
		case RoomM:
			return 10;				
		case Room121:
			return 10;				
		case RoomKitchen:
			return 10;				
		case Room118:
			return 10;				
		case Room117:
			return 10;				
		case Room117L:
			return 10;				
		case Room120:
			return 10;				
		case Room122:
			return 10;				
		case Room123:
			return 10;				
		case Room126:
			return 10;				
		case RoomLobby:
			return 10;				
		case Room104:
			return 10;				
		case Room105:
			return 10;				
		case Room129:
			return 0;				
		case Room129M:
			return 0;				
		case Room129A:
			return 0;				
		case Room129B:
			return 0;				
		default:
			return 0;
		}
	}
	*/
	public SensorPoints getSensorPoints(int roomID)
	{
		switch(ROOMS.values()[roomID])
		{
			case Room106:
				return new SensorPoints(80, 150, 100, 150);
			case Room107:
				return new SensorPoints(250, 500, 250, 490);				
			case Room108:
				return new SensorPoints(100, 150, 100, 150);				
			case Room109:
				return new SensorPoints(175, 500, 175, 490);				
			case Room110:
				return  new SensorPoints(175, 375, 175, 365);				
			/*case Room111:
				return  new SensorPoints(100, 150);				
			case Room112:
				return  new SensorPoints(100, 150);				
			case Room113:
				return  new SensorPoints(100, 150);				
			*/case Room114:
				return new SensorPoints(130, 200, 175, 200);				
			case Room115:
				return new SensorPoints(175, 200, 225, 200);				
			case Room116:
				return new SensorPoints(225, 200, 275, 200);				
			case RoomW:
				return new SensorPoints(280, 375, 360, 375);				
			case RoomStairs:
				return new SensorPoints(360, 375, 580, 375 );				
			case RoomM:
				return new SensorPoints(580, 375, 655, 375);				
			case Room121:
				return new SensorPoints(655, 375, 750, 375);				
			case RoomKitchen:
				return new SensorPoints(765, 345, 765, 365);				
			case Room118:
				return new SensorPoints(825, 375, 875, 375);				
			case Room117:
				return new SensorPoints(875, 480, 875, 510);				
			case Room117L:
				return new SensorPoints(765, 500, 825, 500);				
			case Room120:
				return new SensorPoints(715, 475, 680, 475);				
			case Room122:
				return new SensorPoints(680, 475, 645, 475);				
			case Room123:
				return new SensorPoints(645, 475, 600, 475);				
			case Room126:
				return new SensorPoints(600, 475, 510, 475);				
			case RoomLobby:
				return new SensorPoints(510, 475, 370, 475);				
			case Room104:
				return new SensorPoints(370, 475, 300, 475);				
			case Room105:
				return new SensorPoints(300, 475, 325, 475);				
			case Room129:
				return new SensorPoints(520, 225, 520, 175);				
			case Room129M:
				return new SensorPoints(520, 175, 520, 175);				
			case Room129A:
				return new SensorPoints(455, 175, 475, 175);				
			case Room129B:
				return new SensorPoints(575, 175, 525, 175);				
			default:
				return new SensorPoints(0, 0, 0, 0);
			}
	}
	
}
	
/*
	static SensorPoints Room106 = new SensorPoints(100, 150);
	static SensorPoints Room107 = new SensorPoints(250, 500);
	static SensorPoints Room108 = new SensorPoints(100, 150);
	static SensorPoints Room109 = new SensorPoints(175, 500);
	static SensorPoints Room110 = new SensorPoints(175, 375);
	static SensorPoints RoomW= new SensorPoints(315, 375);
	static SensorPoints RoomStairs = new SensorPoints(450, 375);
	static SensorPoints RoomM = new SensorPoints(625, 375);
	static SensorPoints Room121 = new SensorPoints(700, 375);
	static SensorPoints RoomKitchen = new SensorPoints(775, 375);
	static SensorPoints Room118 = new SensorPoints(875, 375);
	static SensorPoints Room117 = new SensorPoints(875, 500);
	static SensorPoints Room117L = new SensorPoints(775, 500);
	
	static SensorPoints Room120 = new SensorPoints(725, 475);
	static SensorPoints Room122 = new SensorPoints(690, 475);
	static SensorPoints Room123 = new SensorPoints(655, 475);
	static SensorPoints Room126 = new SensorPoints(610, 475);
	
	static SensorPoints RoomLobby = new SensorPoints(520, 475);
	static SensorPoints Room104 = new SensorPoints(380, 475);
	static SensorPoints Room105 = new SensorPoints(315, 475);
	
	static SensorPoints Room129 = new SensorPoints(520, 250);
	static SensorPoints Room129M = new SensorPoints(520, 175);
	static SensorPoints Room129A = new SensorPoints(465, 175);
	static SensorPoints Room129B = new SensorPoints(575, 175);
	
	static SensorPoints Room111 = new SensorPoints(100, 150);
	static SensorPoints Room112 = new SensorPoints(100, 150);
	static SensorPoints Room113 = new SensorPoints(100, 150);
	static SensorPoints Room114 = new SensorPoints(150, 200);
	static SensorPoints Room115 = new SensorPoints(200, 200);
	static SensorPoints Room116 = new SensorPoints(250, 200);
	
	
	
	static SensorPoints Room119 = new SensorPoints(100, 150);
	
	static SensorPoints Room124 = new SensorPoints(100, 150);
	static SensorPoints Room125 = new SensorPoints(100, 150);
	
	static SensorPoints Room127 = new SensorPoints(100, 150);
	static SensorPoints Room128 = new SensorPoints(100, 150);
	*/
	
	

