
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
      host: 'localhost',
      port: 32790,
      username: 'admin',
      //dropSchema: true, // borrar la base
      password: 'root',
      database: 'usuarios',
      entities: [__dirname + '/**/*.entity{.ts,.js}'],
      synchronize: true, // crea las tablas
    }),

  ],
  controllers: [AppController],
  providers: [AppService],
})
export class AppModule { }
