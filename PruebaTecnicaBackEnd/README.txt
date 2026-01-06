OrdenarisRiskEngine – Prueba Técnica Backend
RESUMEN
Este proyecto implementa un motor de evaluación de riesgo crediticio llamado OrdenarisRiskEngine, diseñado para analizar solicitudes financieras de empresas mediante un conjunto de reglas de negocio desacopladas.
El motor evalúa una solicitud a partir de información obtenida de proveedores externos (simulados mediante mocks) y determina un nivel de riesgo final, indicando si el resultado fue causado por una regla determinante o por una combinación de reglas.
REQUISITOS
•	Java 8 o superior
•	No utiliza base de datos (datos simulados mediante mocks)
ESTRUCTURA DEL PROYECTO
•	engine
Contiene el motor principal (OrdenarisRiskEngine) y la lógica de evaluación.
•	model
Modelos de dominio como:
o	RiskRequest
o	EvaluationResult
o	RiskLevel
o	Objetos de datos (contables, pagos, legal).
•	providers
Interfaces que representan fuentes externas de información:
o	DatosContablesProvider
o	HistorialPagosProvider
o	VerificacionLegalProvider
•	rules
Reglas de negocio independientes que implementan ReglaRiesgo.
•	mock
Implementaciones mock de los providers para pruebas.
•	app
Clase Main para ejecutar escenarios de prueba.
FUNCIONAMIENTO DEL MOTOR
•	El motor inicia siempre con nivel de riesgo BAJO.
•	Las reglas se ejecutan en orden.
•	Cada regla puede devolver:
o	ok → no afecta el riesgo
o	subir → incrementa el nivel de riesgo
o	rechazar → regla determinante, finaliza la evaluación
NIVELES DE RIESGO:
BAJO → MEDIO → ALTO → RECHAZADO
REGLAS IMPLEMENTADAS
•	ReglaDeudaActiva
•	ReglaAltaSolicitudVentas
•	ReglaEmpresaNueva
•	ReglaDemandaLegal (determinante)
•	ReglaHistorialExcelente
•	ReglaProductoEstricto
Las reglas legales (procesos legales o embargos) provocan rechazo inmediato, tal como lo establece el documento.
RESULTADO DE EVALUACIÓN
El resultado (EvaluationResult) incluye:
•	Nivel de riesgo final
•	Lista de mensajes de reglas evaluadas
•	Motivo final:
o	Regla determinante
o	Combinación de reglas
o	Evaluación favorable
CÓMO EJECUTAR
1.	Importar el proyecto en un entorno Java.
2.	Compilar con Java 8+.
3.	Ejecutar la clase:
4.	app.Main
5.	Modificando los mocks se pueden simular distintos escenarios.
SUPUESTOS Y LIMITACIONES
•	Las fuentes de datos están simuladas mediante mocks.
•	No existe persistencia ni conexión a servicios reales.
•	El motor no implementa ponderaciones complejas ni reducción de riesgo.
