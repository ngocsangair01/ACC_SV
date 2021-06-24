package com.hithaui.Controller;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.websocket.server.PathParam;

import org.aspectj.internal.lang.annotation.ajcDeclareAnnotation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import com.hithaui.DTO.AccountDTO;
import com.hithaui.Exception.DuplicateException;
import com.hithaui.Exception.NotFoundException;
import com.hithaui.Model.Account;
import com.hithaui.Repositories.AccountRepository;

@RestController
@RequestMapping("/api/accounts")
public class AccountController {

	@Autowired
	private AccountRepository accountRepository;
	
	
	@Autowired
	private Cloudinary cloudinary;
	
	@GetMapping
	public ResponseEntity<?> getAllAccount(){
		List<Account> list= accountRepository.findAll();
		if (list.size()==0) {
			throw new NotFoundException("chưa có tài khoản nào được tạo");
		}
		return ResponseEntity.status(200).body(list);
	}
	
//	@PostMapping("/hai")
//	public ResponseEntity<?> creatAccountWithUP(@RequestBody AccountDTO accountDTO){
//		Account account = accountRepository.findByUsername(accountDTO.getUsername());
//		if (account!=null) {
//			throw new DuplicateException("Tài khoản đã tồn tại");
//		}
//		
//	}
	
//	@PostMapping
//	public ResponseEntity<?> createAcc(@RequestBody ){
//		
//	}
	
	@PostMapping
	public ResponseEntity<?> createAccount (@RequestParam("username") String username, 
			@RequestParam("password") String password, @RequestParam("avt") MultipartFile avtFile) throws IOException{
		Account account= accountRepository.findByUsername(username);
		if (account !=null) {
			throw new DuplicateException("Account has aready exists");
		}
		Map<?, ?> map= cloudinary.uploader().upload(avtFile.getBytes(), ObjectUtils.emptyMap());
		String avtLink = (String) map.get("secure_url");
		
		Account account2= accountRepository.save(new Account(0,username, password, null,null,0,0,0,null,null,null,null));
		
		return ResponseEntity.status(201).body(account2);
	}
	
	@PostMapping("/body")
	public ResponseEntity<?> creatAccoutbyBody(@RequestBody AccountDTO accountDTO){
		Account account= accountRepository.findByUsername(accountDTO.getUsername());
		if (account!=null) {
			throw new DuplicateException("Tài khoản đã tồn tại");
		}
		Account account1= new Account(0,accountDTO.getUsername(), accountDTO.getPassword(), accountDTO.getAvt(),null,0,0,0,null,null,null,null);
		Account account2 = accountRepository.save(account1);
		return ResponseEntity.status(201).body(account2);
		
	}
	@PostMapping("/login")
	public String login(@RequestBody AccountDTO accountDTO){
		Account account = accountRepository.findByUsername(accountDTO.getUsername());
		if (account!=null){
			if (account.getPassword().compareTo(accountDTO.getPassword())==0) {
				return "OK";
			}
		}
		return "fail";
	}
	@PatchMapping("/editpass")
	public ResponseEntity<?> updateAccount (@RequestBody AccountDTO accountDTO){
		Account account = accountRepository.findByUsername(accountDTO.getUsername());
		if (account==null) {
			throw new NotFoundException("not found");
		}
		account.setPassword(accountDTO.getPassword());
		
		Account account2= accountRepository.save(account);
		return ResponseEntity.status(201).body(account2);
		
	}
	@PatchMapping("/{id}")
	public ResponseEntity<?> updateAccount2 (@PathVariable(name = "id") Integer id, @RequestBody AccountDTO accountDTO){
		Optional<Account> account = accountRepository.findById(id);
		if (!account.isPresent()) {
			throw new NotFoundException("k timf thay");
		}
		account.get().setAvt(accountDTO.getAvt());
		Account account2 = accountRepository.save(account.get());
		return ResponseEntity.status(201).body(account2);		
	}

	
}
