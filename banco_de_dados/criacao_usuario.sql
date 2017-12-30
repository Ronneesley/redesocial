create user if not exists 'admin'@'localhost'
	identified by 'redesocial';

grant all on redesocial.* to 'admin'@'localhost';
