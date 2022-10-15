# Cálculo Imposto Renda
 
## Obter valores de um EditText 

```kotlin
var salario = findViewById<EditText>(R.id.salario)
```

## Implementar o Click de um Botão

```kotlin
var btnCalcular = findViewById<Button>(R.id.btnCalcular)

btnCalcular.setOnClickListener {
    calcTax(salario.text.toString().toDouble())
}
```

## Formatar um valor com uma String no arquivo string.xml (abaixo)

```kotlin
var imposto = findViewById<TextView>(R.id.imposto)
imposto.text = resources.getString(R.string.result_tax, tax)
```

## Formatar utilizando NumberFormat

```kotlin
var f = NumberFormat.getCurrencyInstance()

var salarioLiquido = findViewById<TextView>(R.id.salarioLiquido)
salarioLiquido.text = resources.getString(R.string.result_salliquid, f.format(salLiquid))
```

## Arquivo String

```xml
<resources>
    <string name="app_name">Calcula Salário Líquido</string>
    <string name="salario">Salário</string>
    <string name="preencha_salario">Preencha o salário</string>
    <string name="calcular">Calcular</string>
    <string name="salario_liquido">Salário Líquido</string>
    <string name="imposto">Imposto</string>
    <string name="result_salliquid">O salário líquido é %s</string>
    <string name="result_tax">O imposto é R$ %.2f</string>
    <string name="no_tax">Imposto: <b>isento</b></string>
</resources>
```

## Cálculo do Imposto de Renda e Salário Líquido

```kotlin
fun calcTax(salary: Double) {
    var salLiquid = salary
    var tax = 0.0

    if (salary <= 1903.98) {
        tax = 0.0
    } else if (salary <= 2826.65) {
        tax = (salary * 0.075) - 142.8
        salLiquid = salary - tax
    } else if (salary <= 3751.05) {
        tax = (salary * 0.15) - 354.8
        salLiquid = salary - tax
    } else if (salary <= 4664.68) {
        tax = (salary * 0.225) - 636.13
        salLiquid = salary - tax
    } else {
        tax = (salary * 0.275) - 869.36
        salLiquid = salary - tax
    }

    var f = NumberFormat.getCurrencyInstance()

    var salarioLiquido = findViewById<TextView>(R.id.salarioLiquido)
    salarioLiquido.text = resources.getString(R.string.result_salliquid, f.format(salLiquid))

    var imposto = findViewById<TextView>(R.id.imposto)
    if (tax != 0.0) {
        imposto.text = resources.getString(R.string.result_tax, tax)
    } else {
        imposto.text = resources.getString(R.string.no_tax)
    }

    var salario = findViewById<EditText>(R.id.salario)
    salario.setText("")

}
```
