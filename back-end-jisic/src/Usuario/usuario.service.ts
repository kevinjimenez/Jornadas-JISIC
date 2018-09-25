import { Injectable } from "@nestjs/common";
import { InjectRepository } from "@nestjs/typeorm";
import { UsuarioEntity } from "./usuario.entity";
import { Repository } from 'typeorm';

@Injectable()

export class UsuarioService {

    constructor(
        @InjectRepository(UsuarioEntity)
        private readonly _usuarioRepository: Repository<UsuarioEntity>
    ) { }


    async todos():Promise<UsuarioEntity[]>{
        return await this._usuarioRepository.find()
    }


    async findByName(name: string): Promise<UsuarioEntity> {
        return await this._usuarioRepository.findOne({ nombre_1: name })
    }

    async findByLastName(apellido: string): Promise<UsuarioEntity> {
        return await this._usuarioRepository.findOne({ apellido_1: apellido })
    }

    async findByEmailAndPassword(email: string, password: string): Promise<UsuarioEntity> {
        return await this._usuarioRepository.findOne(
            {
                where: {
                    email,
                    password
                }
            }
        )
    }

    async BuscarPorCosulta(consulta: object): Promise<UsuarioEntity> {
        return await this._usuarioRepository.findOne(
            {
                where: consulta
            }
        )
    }

}