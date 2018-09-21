/**
 * Usuario.js
 *
 * @description :: A model definition.  Represents a database table/collection/etc.
 * @docs        :: https://sailsjs.com/docs/concepts/models-and-orm/models
 */

module.exports = {

  attributes: {
    // id: {
    //   type: 'number',
    //   unique: true,
    //   required: true      
    // },
    nombre_1: {
      type: 'string',
      required: true
    },
    nombre_2: {
      type: 'string',
      required: true
    },
    apellido_1: {
      type: 'string',
      required: true
    },
    apellido_2: {
      type: 'string',
      required: true
    },
    password: {
      type: 'string',
      required: true
    },
    email: {
      type: 'string',
      unique: true,
      required: true
    },
    numeroDeTelefono: {
      type: 'number',      
    },
    numeroDeCedula: {
      type: 'number',  
    },
    // //////////////////////////////////// CODIGO QR
    // codigoQR: {}  
  },

};

