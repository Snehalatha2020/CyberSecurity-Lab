from Crypto.Cipher import AES

key = b'StrongAESKey1234'

cipher = AES.new(key, AES.MODE_EAX)
data = "Hello, this is a AES encrpt".encode()
nonce = cipher.nonce
ciphertext = cipher.encrypt(data)

print("Cipher text:", ciphertext.hex())  

cipher = AES.new(key, AES.MODE_EAX, nonce=nonce)
plaintext = cipher.decrypt(ciphertext)

print("Plain text:", plaintext.decode())  