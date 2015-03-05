class paths{
	public static void main(String[] args)throws Exception{
		boolean getStatus;
		try{ 
		 	getStatus = Path.path(args[0],args[1]);
			System.out.println(getStatus);
		}catch(Exception e){
			System.out.println(e.getMessage());
		}
	}
}