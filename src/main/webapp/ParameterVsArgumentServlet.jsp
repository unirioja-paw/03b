<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>PAW</title>
    </head>
    <body>
        <h1>Usuario</h1>
        <form method="post">
            <div>
                Este formulario se envia por POST. Prueba a cambiarlo a GET.
            </div>
            <fieldset>
                <div>
                    <label for="fusername">Nombre de usuario</label>
                    <input type="text" name="username" id="fusername">
                </div>
                <div>
                    <label for="field-not-submitted">Otro campo</label>
                    <input type="text" id="field-not-submitted">
                    <br/>
                    Este input no tiene atributo "name"; no se incluirá en la petición HTTP de envio del formulario
                </div>
            </fieldset>
            <div>
                <button type="submit" value="">Aceptar</button>
            </div>

        </form>


    </body>
</html>
