insert into roles (rol) values
('ROLE_ADMINISTRADOR'),
('ROLE_VENTAS'),
('ROLE_ENVIOS');


insert into usuarios (username, password, estado, nombres, apellidos, email,ci,telefono) values
('admin','$2a$10$gWCPSP9xPe2SoyuL47Hs5eAdI05Rra9uTEhjaHfUhrfXBBCY/ZMJi',true,'admin','admin','admin@admin.com','123456','12345678'),
('venta','$2a$10$6lYpJTqIl/CzkFe6dw2nJ.X.dYFgL0iKWuOFt473Kxsw4QxVs/xf2',true,'venta','venta','venta@venta.com','123456','12345678'),
('envio','$2a$10$6lYpJTqIl/CzkFe6dw2nJ.X.dYFgL0iKWuOFt473Kxsw4QxVs/xf2',true,'envio','envio','envio@envio.com','123456','12345678');


insert into roles_usuarios values(1,1),(2,2),(3,3);

