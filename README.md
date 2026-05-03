# Flutter Blue (BLE)

Aplicativo **Flutter** que utiliza o pacote [`flutter_blue`](https://pub.dev/packages/flutter_blue) para comunicação Bluetooth Low Energy com dispositivos compatíveis. Projeto base para experimentos mobile + IoT.

## Stack

- Flutter 3.x / Dart 3
- `flutter_blue` ^0.8.0

## Pré-requisitos

- [Flutter SDK](https://docs.flutter.dev/get-started/install) estável
- Android Studio / Xcode conforme a plataforma alvo

## Como rodar

```bash
flutter pub get
flutter run
```

No **Android**, permissões de Bluetooth/localização podem ser exigidas conforme a versão do SO; revise `AndroidManifest.xml` se necessário.

## Licença

Veja [LICENSE](LICENSE).
