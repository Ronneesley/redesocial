create user if not exists 'admin_teste'@'localhost' identified by 'banco_teste';

grant all on bd_teste1.* to 'admin_teste'@'localhost';
grant all on bd_teste2.* to 'admin_teste'@'localhost';