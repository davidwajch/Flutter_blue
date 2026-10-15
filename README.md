# BLL - Bluetooth Low Energy Manager

App Flutter para comunicação e gerenciamento de dispositivos Bluetooth Low Energy (BLE), com suporte a roteamento de áudio Bluetooth.

## O que faz

- Escaneia e lista dispositivos BLE disponíveis
- Conecta/desconecta de dispositivos BLE
- Explora serviços, características e descritores GATT
- Lê/escreve dados em características
- Habilita notificações de características
- Alterna roteamento de áudio Bluetooth (via canal de plataforma Android)
- Lê número serial de dispositivos compatíveis

## Stack

- **Flutter** 3.x / Dart 3
- **flutter_blue** ^0.8.0 - comunicação BLE
- **Platform Channel** (Android/Kotlin) - controle de áudio Bluetooth

## Estrutura

```
lib/
├── main.dart           # App principal, telas de scan e dispositivo
├── widgets.dart        # Widgets customizados (tiles de serviços/características)
└── audio_manager.dart  # Bridge Flutter/Android para áudio BT

android/app/src/main/kotlin/com/example/bll/
├── MainActivity.kt              # Activity principal, setup do MethodChannel
└── BluetoothAudioManager.kt     # Gerencia SCO e roteamento de áudio
```

## Como rodar

### Pré-requisitos

- [Flutter SDK](https://docs.flutter.dev/get-started/install) 3.x ou superior
- Android Studio (para Android) ou Xcode (para iOS)

### Instalação

```bash
flutter pub get
flutter run
```

### Permissões

**Android:** permissões de Bluetooth e localização são necessárias. Configuradas em `android/app/src/main/AndroidManifest.xml`. No Android 12+, requer permissões de BLUETOOTH_SCAN e BLUETOOTH_CONNECT.

**iOS:** adicionar NSBluetoothAlwaysUsageDescription no Info.plist.

## Funcionalidades implementadas

- ✅ Scan de dispositivos BLE (classic + dual mode com suporte a conexão)
- ✅ Conexão automática e manual
- ✅ Descoberta de serviços GATT
- ✅ Leitura/escrita de características
- ✅ Controle de notificações
- ✅ Ajuste de MTU
- ✅ Toggle de áudio Bluetooth (Android)

## Próximos passos

- [ ] Implementar gerenciamento de permissões em runtime
- [ ] Adicionar filtros personalizados de scan (UUID, RSSI)
- [ ] Melhorar tratamento de erros e feedback ao usuário
- [ ] Persistir histórico de dispositivos conectados
- [ ] Suporte a múltiplas conexões simultâneas
- [ ] Implementar funcionalidade de áudio no iOS

## Licença

MIT - veja [LICENSE](LICENSE) para detalhes.
