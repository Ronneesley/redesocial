//Considere que ja tenha sido declarado e instanciados todos os objetos necessarios
try { 
	connection.setAutoCommit(false); 
	preparedStatement = connection.prepareStatement( "Um SQL qualquer aqui" ); 

	preparedStatement.executeUpdate(); 
	
	connection.commit();  
}catch( Exception e ) { 
	connection.rollback(); 
} 