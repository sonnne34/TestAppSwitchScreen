Реализация приложения, состоящего из одного активити и двух фрагментов.
При запуске приложения отображаем фрагмент1.

Фрагмент1 включает в себя три кнопки (пусть будут красная/зеленая/синяя) расположенные в вертикальный столбец друг под другом (путь отступ будет между ними равен 10). Их расположение должно быть реализовано с помощью ConstraintSet. При нажатии на красную кнопку - сворачиваем приложение, при нажатии на зеленую кнопку - удаляем зеленую кнопку*. При нажатии на синюю кнопку - показываем фрагмент2**.

Фрагмент2 включает в себя одну кнопку, при нажатии на которую мы возвращаемся к фрагменту1.

Примечания:
* после удаления зеленой кнопки, не должно остаться пустого места между красной и синей кнопками
** фрагмент1 не должен удаляться, при возврате из фрагмента2 на фрагмент1, фрагмент1 не должен пересоздаваться

Sorry for the bad English:
Implementation of an application consisting of one activity and two fragments.

When the app starts, we display the snippet1.

Snippet1 includes three buttons (let them be red/green/blue) arranged in a vertical column under each other (the path indent will be between them equal to 10). Their location must be implemented using a ConstraintSet. When you click on the red button-minimize the application, when you click on the green button-delete the green button*. When you click on the blue button, we show the fragment2**.



Fragment2 includes a single button, when clicked, we return to fragment1.



Notes:

* After removing the green button, there should be no empty space between the red and blue buttons

** fragment1 should not be deleted, when returning from fragment2 to fragment1, fragment1 should not be recreated