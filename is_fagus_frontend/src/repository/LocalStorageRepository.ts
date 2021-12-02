class LocalStorageRepository {


    save(id: string, value: any): void {
        localStorage.setItem(id, value);
    }

    delete(id: string): void {
        localStorage.removeItem(id);
    }

    findById(id: string) {
        return localStorage.getItem(id)
    }

    clear(): void {
        localStorage.clear();
    }

    saveUser(user: any): void {
        localStorage.setItem("FagusUser", JSON.stringify(user))
    }

    getUser() {
        return localStorage.getItem("FagusUser")
    }

    removeUser() {
        return localStorage.removeItem("FagusUser")
    }
}

export default new LocalStorageRepository();