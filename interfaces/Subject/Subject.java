package interfaces.Subject;

import interfaces.Observer.Observer;

public interface Subject {
    public void setObserver(Observer observer);

    public void removeObserver(Observer observer);

    public void notifyListeners();
}
