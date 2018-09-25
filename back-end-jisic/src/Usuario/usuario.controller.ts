import { Controller, Get, Query } from "@nestjs/common";
import { UsuarioService } from "./usuario.service";

@Controller('usuario')

export class UsuarioController {

    constructor(private readonly _usuarioService: UsuarioService) { }

    @Get()
    todos(){
        return this._usuarioService.todos()
    }

    @Get('buscarPorEmailYPassword')
    buscarPorEmailYPassword(
        @Query('email') email,
        @Query('password') password
    ) {
        return this._usuarioService.findByEmailAndPassword(email,password);
    }

    @Get('buscarPorNombre')
    buscarPorNombre(
        @Query('nombre_1') nombre_1
    ){
        return this._usuarioService.findByName(nombre_1)
    }

    @Get('buscarPorConsulta')
    buscarPorConsulta(
        @Query() consulta
    ){
        return this._usuarioService.BuscarPorCosulta(consulta)
    }
    

}