import 'package:flutter_test/flutter_test.dart';
import 'package:bll/main.dart';

void main() {
  testWidgets('App inicializa sem erros', (WidgetTester tester) async {
    await tester.pumpWidget(const FlutterBlueApp());
    expect(find.byType(FlutterBlueApp), findsOneWidget);
  });
}
