# Kotlin Compiler plugin workshop tasks

- Реализация Transformer в рамказ задачи реализуется в FunctionCompilerTransformerTNumber - где
  Number - номер задачи. </br>
  Например Task 1 - `FunctionCompilerTransformerT1.kt`. </br>
- `dependencies: TransformerDeps.Dependencies` - dependencies дает доступ к `IrPluginContext` и
  `CompilerLogger`.
- Каждая задача должна создаваться в своем файле. При написании новой задачи - старую оставляем
  нетронутой. Это необходимо для корректного прогона тестов.

Начало пути - https://gist.github.com/stslex/13353957983304738e525830cb886058

### для запуска тестов:

#### Запустит все тесты в проекте
```bash
./gradlew runTestWithPlugin
```

#### Запустит тесты только для одной/нескольких задач - указывать через запятую
```bash
./gradlew runTestWithPlugin --args="1,2"
```