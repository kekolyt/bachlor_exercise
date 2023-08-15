# Anleitung zum Versuch

### 0. Lies dir diese ReadMe-Datei komplett durch bevor du beginnst
### 1. Erstelle einen Branch
Erstelle einen neuen Branch (Naming egal) und "öffne" ihn.
```
git branch with-ChatGPT
git checkout -b dein-branch 
```
### 2. Öffne die Datei Matrix.java & starte eine Stoppuhr
### 3. Bearbeite den Code
Der Code in Matrix,java enthält Funktionen, welche die Funktion der unten genannten Experimentaufgaben erfüllen sollen.
Der Code ist in seiner derzeitigen Form nicht lauffähig und enthält Fehler, bitte finde und korrigiere die Fehler.
Bitte denke daran, dass du den Code auch gern so formatieren und kommentieren kannst, wie du es gewohnt bist.
Du wirst gebeten für die Berichtigung des Codes ChatGPT zur Unterstützung zu nutzen, aber in welchem Ausmaß du das machst, ist dir überlassen.<br>

Bitte ändere nichts an der MatrixOutput.java, diese soll nur die Methoden formatiert ausgeben.

Tipp: Falls du eine Pause einlegen möchtest, kannst du die Stoppuhr einfach pausieren, denn es ist nicht nötig alles in einem Durchlauf zu lösen.
### 4. Überprüfe den Code (MatrixOutput.java)
Es steht eine Datei mit prints zu Verfügung, welche deinen Code formatiert ausgibt. Dafür musst du nur die MatrixOutput.java öffnen und ausführen.
### 5. Stoppe die Stoppuhr
Wenn du den Versuch beenden willst, stoppe die Stoppuhr und notiere die Zeit.
### 6. Teile deinen Chatverlauf mit ChatGPT
Bei ChatGPT gibt es oben rechts die Möglichkeit seinen Verlauf zu teilen. Bitte gehe auf den Button und anschließend "Copy Link".
Diesen kannst du in der folgenden Umfrage einfügen.

Falls du zwischenzeitlich das Fenster schließen willst, mache diesen Schritt vor jedem Schließen.
### 7. Beantworte die Umfrage
Es gibt eine Umfrage, welche du bitte ehrlich ausfüllen sollst.
### 8. Pushe deine Ergebnisse
Deine bearbeiteten Ergebnisse in deinen neu erstellten Branch pushen.
```
git add .
git commit -m "Beschreibung deiner Änderungen"
git push origin dein-branch
```

# Experimentaufgaben

### 1. Methode: isSquareMatrix

Eine Methode welche prüft ob eine Matrix quadratisch ist. Eine quadratische Matrix hat dieselbe Anzahl von Zeilen und Spalten. Die Methode sollte true zurückgeben, wenn die übergebene Matrix quadratisch ist, und false wenn nicht.

#### Beispiel:
2 3<br>
5 6 // Sollte true zurückgeben

2 3<br>
8 1<br>
5 6 // Sollte false zurückgeben

### 2. Methode: transpose

Eine Methode die eine Matrix transponiert, also das vertauschen von Zeilen und Spalten. Die Methode sollte die ursprüngliche Matrix als Parameter annehmen und die transponierte Matrix zurückgeben.

#### Beispiel:
1 2<br>
3 4<br>
5 6<br>

Sollte zurückgeben:<br>
1 3 5<br>
2 4 6<br>

### 3. Methode: mirrorMatrix

Eine Methode die eine Matrix an der Vertikalen spiegelt. Die Methode sollte die ursprüngliche Matrix als Parameter annehmen und die gespiegelte Matrix zurückgeben.

#### Beispiel:
2 3<br>
5 6<br>

Sollte zurückgeben:<br>
3 2<br>
6 5<br>

### 4. Methode: rotate90Degrees

Eine Methode die eine Matrix um 90 Grad im Uhrzeigersinn dreht. Die Methode sollte die ursprüngliche Matrix als Parameter annehmen und die gedrehte Matrix zurückgeben.

#### Beispiel:
2 3<br>
5 6<br>

Sollte zurückgeben:<br>
5 2<br>
6 3<br>


### 5. Methode: sumDiagonal

Eine Methode die die Summe der Elemente auf der Hauptdiagonale einer quadratischen Matrix berechnet. Die Matrix sollte als Parameter übergeben werden.

#### Beispiel:

1 2 3<br>
4 5 6<br>
7 8 9<br>
Sollte zurückgeben:
15
### 6. Methode: hadamardProduct

Eine Methode die das Hadamard-Produkt (Element für Element Multiplikation) zweier Matrizen berechnet. Beide Matrizen sollten als Parameter übergeben werden.

#### Beispiel:

1 2&nbsp;&nbsp;&nbsp;&&nbsp;&nbsp;&nbsp;5 6<br>
3 4&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;7 8<br>

Sollte zurückgeben:<br>
05 12<br>
21 32<br>
### 7. Methode: sortMatrix

Eine Methode die die Elemente einer Matrix sortiert. Die Methode sollte die zu sortierende Matrix als Parameter akzeptieren.

#### Beispiel:

9 8 7<br>
6 5 4<br>
3 2 1<br>

Sollte zurückgeben:<br>
1 2 3<br>
4 5 6<br>
7 8 9<br>
