���������� ����������, ���������� �� ������ �������� � ���� ����������.
��� ������� ���������� ���������� ��������1.

��������1 �������� � ���� ��� ������ (����� ����� �������/�������/�����) ������������� � ������������ ������� ���� ��� ������ (���� ������ ����� ����� ���� ����� 10). �� ������������ ������ ���� ����������� � ������� ConstraintSet. ��� ������� �� ������� ������ - ����������� ����������, ��� ������� �� ������� ������ - ������� ������� ������*. ��� ������� �� ����� ������ - ���������� ��������2**.

��������2 �������� � ���� ���� ������, ��� ������� �� ������� �� ������������ � ���������1.

����������:
* ����� �������� ������� ������, �� ������ �������� ������� ����� ����� ������� � ����� ��������
** ��������1 �� ������ ���������, ��� �������� �� ���������2 �� ��������1, ��������1 �� ������ ���������������

Sorry for the bad English:
Implementation of an application consisting of one activity and two fragments.

When the app starts, we display the snippet1.

Snippet1 includes three buttons (let them be red/green/blue) arranged in a vertical column under each other (the path indent will be between them equal to 10). Their location must be implemented using a ConstraintSet. When you click on the red button-minimize the application, when you click on the green button-delete the green button*. When you click on the blue button, we show the fragment2**.



Fragment2 includes a single button, when clicked, we return to fragment1.



Notes:

* After removing the green button, there should be no empty space between the red and blue buttons

** fragment1 should not be deleted, when returning from fragment2 to fragment1, fragment1 should not be recreated