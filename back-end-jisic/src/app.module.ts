
import { AppController } from './app.controller';
import { AppService } from './app.service';
import { TypeOrmModule } from '@nestjs/typeorm';
import { Module } from '@nestjs/common';
import { UsuarioModule } from 'Usuario/usuario.module';

@Module({
  imports: [
    UsuarioModule,
    TypeOrmModule.forRoot({
      type: 'mysql',
      host: 'usuarios.mysql.database.azure.com',
      port: 3306,
      username: 'kevin@usuarios',
      //dropSchema: true, // borrar la base
      password: 'Kev-1723',
      database: 'usuarios',
      entities: [__dirname + '/**/*.entity{.ts,.js}'],
      synchronize: true, // crea las tablas
      extra:{
        ssl:true
      }
    }),

  ],
  controllers: [AppController],
  providers: [AppService],
})
export class AppModule { }
