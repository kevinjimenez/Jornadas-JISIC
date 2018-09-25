import { Entity, PrimaryGeneratedColumn, Column } from 'typeorm'

@Entity('usuario')

export class UsuarioEntity {

    @PrimaryGeneratedColumn()
    id: number;

    @Column()
    nombre_1:string

    @Column()
    nombre_2:string

    @Column()
    apellido_1:string

    @Column()
    apellido_2:string

    @Column()
    password:string

    @Column()
    email:string

    @Column()
    numeroDeTelefono:number

    @Column()
    numeroDeCedula:number

}